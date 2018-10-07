
/*~~~~~~~~~~~ Data Modul ~~~~~~~~~~~*/
var budgetController = (function() {
    
    /*~~~ Data structers ~~~~*/
    var Expense = function(id, description, value){
        this.id = id;
        this.description = description;
        this.value = value;
        this.percentage = -1;
    };
    
    Expense.prototype.calcPercentage = function(totalIncome){
        if(totalIncome > 0){
            this.percentage = Math.round((this.value / totalIncome) * 100);    
        } else {
            this.percentage = -1;
        }      
    };
    
    Expense.prototype.getPercentage = function(){
        return this.percentage;
    };
    
    var Income = function(id, description, value){
        this.id = id;
        this.description = description;
        this.value = value;
    };
    
    /*~~~ Data base ~~~~*/
    var data = {
        allItems : {
            expense: [],
            income: []
        },
        total: {
            expense: 0,
            income: 0
        },
        budget: 0,
        percentage: -1
    };
    
    /*~~~ Functions ~~~~*/
    
    var calculateTotal = function(data){
        
        var sum = 0;
            
        data.forEach(function(current){
           sum += current.value;
        }); 
        
        return sum;
    };
    
    /*~~~ Public ~~~~*/
    return {
        
        /*~~~~ Add/Delete ~~~~*/
        addItem: function(type, des, val) {
            
            var newItem, ID;
                        
            //Create new ID
            if (data.allItems[type].length > 0){
                ID = (data.allItems[type][(data.allItems[type].length - 1)].id) + 1;    
            } else {
                ID = 0;
            }
            
            
            //Creat new item based on type ('income' or 'expense')
            if(type === 'expense'){
                newItem = new Expense(ID, des, val);
            } else if(type === 'income'){
                newItem = new Income(ID, des, val);
            }
            
            //Add new itme to the array 
            data.allItems[type].push(newItem);
                        
            //Return the new element we created
            return newItem;
        },
        
        deleteItem: function(type, id){
            
            var ids, index;
            
            ids = data.allItems[type].map(function(current){
               return current.id;  
            });
            
            index = ids.indexOf(id);
                        
            if(index !== -1 ){
                data.allItems[type].splice(index, 1);
            }
        },
        
        /*~~~~ Calculation functions ~~~~*/
        calculateBudget: function() {
          
            // calculate total income and expense
            data.total.expense = calculateTotal(data.allItems.expense);
            data.total.income = calculateTotal(data.allItems.income);
            
            // calculate budget
            data.budget = data.total.income - data.total.expense 
                        
            //calculate precentage of expenses
            if ( data.total.income > 0 ){
                data.percentage = Math.round((data.total.expense / data.total.income)*100);
            } else {
                 data.percentage = -1;
            }
        },
        
        calculatePercentages: function() {
            
            data.allItems.expense.forEach(function(currnet){
                currnet.calcPercentage(data.total.income);
            });            
        },
        
        /*~~~~ get Data ~~~~*/
        getBudget: function() {
          return {
              budget: data.budget,
              percentage: data.percentage,
              expense: data.total.expense,
              income: data.total.income
              
          }     
        },
        
        getPercentages: function(){
            
            var allPercentages;
            
            allPercentages = data.allItems.expense.map(function(current){
                return current.getPercentage();
            });
            
            return allPercentages;
            
        },
        
        /*~~~~ Testing functions ~~~~*/
        testing: function(){
            return data;
        }
        
    };
        
 
})();



/*~~~~~~~~~~~ UI Modul ~~~~~~~~~~~*/
var UIController = (function() {
    
    var DOMStrings = {
        /*~~~~ Input Text ~~~~*/
        inputType: '.add__type',
        inputDescription: '.add__description',
        inputValue: '.add__value',
        
        /*~~~~ Buttons ~~~~*/
        addBtn: '.add__btn',
        
        /*~~~~ Labels ~~~~*/
        incomeContiner: '.income__list',
        expensesContiner: '.expenses__list',
        totalIncomeContainer: '.budget__income--value',
        totalExpensesContainer: '.budget__expenses--value',
        totalPercentageContainer: '.budget__expenses--percentage',
        budget: '.budget__value',
        expensesPercentage: '.item__percentage',
        
        /*~~~~ HTML continer ~~~~*/
        incExpContiner: '.container' 
    }
    
    return {
        getInput: function(){
            return {            
                type: document.querySelector(DOMStrings.inputType).value, // 'inc' (+) or 'exp' (-);
                description: document.querySelector(DOMStrings.inputDescription).value,
                value: parseFloat(document.querySelector(DOMStrings.inputValue).value)
            };
        },
        
        getDOMStrings: function(){
            return DOMStrings;
        },
        
        addListItem: function(obj, type){
            var html, newHtml, element;
            
            //Creat HTML string with placeholder text
            if (type === 'income'){
                element = DOMStrings.incomeContiner;
                
                html = '<div class="item clearfix" id="income-%id%"> <div class="item__description">%description%</div> <div class="right clearfix"> <div class="item__value">+ %value%</div> <div class="item__delete"> <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button> </div> </div> </div>'    
            } else if (type === 'expense'){
                element = DOMStrings.expensesContiner;
                
                html = '<div class="item clearfix" id="expense-%id%"> <div class="item__description">%description%</div> <div class="right clearfix"> <div class="item__value">- %value%</div> <div class="item__percentage">21%</div> <div class="item__delete"> <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button> </div> </div> </div>' 
            }
            
            //Replace text with some data
            newHtml = html.replace('%id%', obj.id);
            newHtml = newHtml.replace('%description%', obj.description);
            newHtml = newHtml.replace('%value%', obj.value);
            
            
            //Insert HTML into the dome
            document.querySelector(element).insertAdjacentHTML('beforeend', newHtml);
        },
        
        removeItem: function(itemId){
            
            var el = document.getElementById(itemId);
            el.parentNode.removeChild(el);
            
        },
        
        clearFields: function() {  
            var fields, fieldsArr;
            
            fields = document.querySelectorAll(DOMStrings.inputDescription + ', ' + DOMStrings.inputValue);
            
            fieldsArr = Array.prototype.slice.call(fields);
            
            fieldsArr.forEach(function(current, index, array) {
                current.value = "";
            });
            
            fieldsArr[0].focus();
        },
        
        setBudget: function(obj) {
            var totalIncome, totalExpenses, percentage, budget;
            
            //Set all the CSS classes
            totalIncome = document.querySelector(DOMStrings.totalIncomeContainer);
            totalExpenses = document.querySelector(DOMStrings.totalExpensesContainer);
            percentage = document.querySelector(DOMStrings.totalPercentageContainer);
            budget = document.querySelector(DOMStrings.budget);
            
            //Change the labels
            totalIncome.textContent = obj.income;
            totalExpenses.textContent = obj.expense;
            budget.textContent = obj.budget;
            
            //Make sure the precentage in not null
            if(obj.percentage > 0){
                percentage.textContent = obj.percentage + '%';   
            } else {
                percentage.textContent = '---';
            }                 
        },
        
        displayPercentages: function(allPercentages){
            
            var fields = document.querySelectorAll(DOMStrings.expensesPercentage);
            
            var nodeListForEach = function(list, callBack){
              
                for (var i = 0 ; i < list.length ; i++){
                    callBack(list[i], i);
                }
                
            };
            
            nodeListForEach(fields, function(current, index){

                if (allPercentages[index] > 0){
                    current.textContent = allPercentages[index] + '%'; 
                } else {
                    current.textContent = '---';
                }     
            });
            
        },
        
        initUI: function(){
            var totalIncome, totalExpenses, percentage, budget;
            
            //Set all the CSS classes
            totalIncome = document.querySelector(DOMStrings.totalIncomeContainer);
            totalExpenses = document.querySelector(DOMStrings.totalExpensesContainer);
            percentage = document.querySelector(DOMStrings.totalPercentageContainer);
            budget = document.querySelector(DOMStrings.budget);
            
            //clear the labels 
            totalIncome.textContent = 0;
            totalExpenses.textContent = 0;
            budget.textContent = 0;
            percentage.textContent = '---';
            
        }
    };
        
    
    
    
})();

/*~~~~~~~~~~~ Controller Modul ~~~~~~~~~~~*/
var controller = (function(budgetCtrl, UICtrl) {
    
    /*~~~~~~~~~~~ Event listners ~~~~~~~~~~~*/
    var setupEventListeners = function(){
        var DOM = UICtrl.getDOMStrings();
        
        document.querySelector(DOM.addBtn).addEventListener('click', ctrlAddItem);
    
        document.addEventListener('keypress', function(event) { //It is also common to type only 'e' instead of event
             var keyCodeFlag = 13;

             if (event.keyCode === keyCodeFlag || event.which === keyCodeFlag){
                 ctrlAddItem();
             }
         });
        
        document.querySelector(DOM.incExpContiner).addEventListener('click', ctrlDeleteItem);
    };
         
    /*~~~~~~~~~~~ Functions ~~~~~~~~~~~*/
    var updateBudget = function(){
        var budget;
        
        //1. Calculate new budget
        budgetCtrl.calculateBudget();
        
        //2. returns the badget
        budget = budgetCtrl.getBudget();
        
        //3.Display the new budget in the UI
        UICtrl.setBudget(budget);
        
    };
    
    var updateExpensesPercentage = function (){
        
        var allPercentages;
        
        //1. Calculate the percentages
        budgetCtrl.calculatePercentages();
        
        //2. Read from budget controller
        allPercentages = budgetCtrl.getPercentages();
        
        //3. update the UI 
        UICtrl.displayPercentages(allPercentages);
        
    };
    
    var ctrlAddItem  = function (){
        
        var input, newItem;
        
        //1. Get the input data
        input =  UICtrl.getInput();
        
        //Test that the data is valid
        if(input.description !== "" && !isNaN(input.value) && input.value > 0 ){
            
            //2. Send data to the budget controller
            newItem = budgetCtrl.addItem(input.type, input.description, input.value);
        
            //3. Add data to the UI and clear fields
            UICtrl.addListItem(newItem, input.type);
            UICtrl.clearFields();    

            //4. Calculate and update budget
            updateBudget();
            
            //5. update the percentages
            updateExpensesPercentage();
        }   
    };
    
    var ctrlDeleteItem = function (event){
        
        var itemID, splitID, type, ID;
        
        
        //1. Get Item's data
        itemID = event.target.parentNode.parentNode.parentNode.parentNode.id;
        
        if(itemID) {
            splitID = itemID.split('-');
            type = splitID[0];
            ID = parseFloat(splitID[1]);
        }
        
        //2. Delete Item from data and update budget
        budgetCtrl.deleteItem(type, ID);
                
        //4. Delete Item from UI
        UICtrl.removeItem(itemID);
        
        //5. Update new budget in UI
        updateBudget();
        
        //6. update the percentages
        updateExpensesPercentage();
        
        
    };
    
    
    return {
        init: function(){                          
            setupEventListeners();
            UICtrl.initUI();
        }
    }
     
})(budgetController, UIController);


controller.init();