
/*~~~~~~~~~~~ Data Modul ~~~~~~~~~~~*/
var budgetController = (function() {
    
    var Expense = function(id, description, value){
        this.id = id;
        this.description = description;
        this.value = value;
    };
    
    var Income = function(id, description, value){
        this.id = id;
        this.description = description;
        this.value = value;
    };
    
    var data = {
        allItems : {
            expense: [],
            income: []
        },
        total: {
            exp: 0,
            inc: 0
        }
    };
    
    return {
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
        
        testing: function(){
            console.log(data);
        }
    }
 
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
        
        /*~~~~ contanies ~~~~*/
        incomeContiner: '.income__list',
        expensesContiner: '.expenses__list'
        
    }
    
    return {
        getInput: function(){
            return {            
                type: document.querySelector(DOMStrings.inputType).value, // 'inc' (+) or 'exp' (-);
                description: document.querySelector(DOMStrings.inputDescription).value,
                value: document.querySelector(DOMStrings.inputValue).value
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
                
                html = '<div class="item clearfix" id="expense-%id%"> <div class="item__description">%description%</div> <div class="right clearfix"> <div class="item__value">- %value%"</div> <div class="item__percentage">21%</div> <div class="item__delete"> <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button> </div> </div> </div>' 
            }
            
            //Replace text with some data
            newHtml = html.replace('%id%', obj.id);
            newHtml = newHtml.replace('%description%', obj.description);
            newHtml = newHtml.replace('%value%', obj.value);
            
            
            //Insert HTML into the dome
            document.querySelector(element).insertAdjacentHTML('beforeend', newHtml);
        }
    };
    
})();

/*~~~~~~~~~~~ Controller Modul ~~~~~~~~~~~*/
var controller = (function(budgetCtrl, UICtrl) {
    
    /*~~~~~~~~~~~ Event listners ~~~~~~~~~~~*/
    var setupEventListeners = function(){
        var DOM = UICtrl.getDOMStrings();
        
        document.querySelector(DOM.addBtn).addEventListener('click', ctrlAddItem);
    
        document.addEventListener('keypress', function(event) { //it is also common to type only 'e' instead of event
             var keyCodeFlag = 13;

             if (event.keyCode === keyCodeFlag || event.which === keyCodeFlag){
                 ctrlAddItem();
             }
         });
    };
         
    /*~~~~~~~~~~~ Functions ~~~~~~~~~~~*/
    var ctrlAddItem  = function (){
        
        var input, newItem;
        
        //1. Get the input data
        input =  UICtrl.getInput();
        
        //2. Send data to the budget controller
        newItem = budgetCtrl.addItem(input.type, input.description, input.value);
        
        //3. Add data to the UI
        UICtrl.addListItem(newItem, input.type);
        
        //4. Calculate new budget
        
        //5.Display the new budget in the UI
        
    };
    
    
    return {
        init: function(){                          
            setupEventListeners();
        }
    }
     
})(budgetController, UIController);


controller.init();