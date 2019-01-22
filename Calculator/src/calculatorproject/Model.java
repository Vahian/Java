//This class is to hold the bulk of the programing and calculations
package calculatorproject;
/**
 * David Kirk
 * Student ID: 91025041
 */
public class Model {
    private double num1;
    private double num2;
    private String message = "it works";
    private String result;
    private boolean clear;   
    private int operator = 10;
    private int rounder = 2;
    private boolean radians = false;
    private String errorMessage = "No Error set";
    public boolean errorPrint = false;
    
    public Model(){
        initialise();
    } 
    protected void initialise(){
        reset();
    }   
    public void reset(){
        num1 = 0;
        num2 = 0;
        operator = 10;
        result = "";
        setMessage("0.0");
        setClear (true);
        setErrorMessage("No Error set");
        errorPrint = false;
        
    }
    
    //This method is to reset all fields to ensure valitity of data. 
      
    public void setNum1(String s){
        if (s != null){
            this.num1 = Double.parseDouble(s);
        }
        else{
            setErrorMessage("First number was null");
            errorPrint = true;
        }
    }
    public double getNum1(){
        return num1;
    }
    public void setNum2(String s){
        if (s != null){
            this.num2 = Double.parseDouble(s);
            }
        else{
            setErrorMessage("First number was null");
            errorPrint = true;
        }
    }  
    public double getNum2(){
        return num2;
    }
    public void setClear(boolean b){
        this.clear = b;
    }
    public boolean getClear(){
        return clear;
    }
    public void setMessage(String s){
        this.message = s;
    }
    public String getMessage(){
        return message;
    }
    public void setOperator(int i){
        this.operator = i;
    }
    public int getOperator(){
        return operator;
    }
    public void setRounder(int i){
        this.rounder = i;
    }
    public int getRounder(){
        return rounder;
    }   
    public void setResult(String s){
        result = s;
    }
    public String getResult(){
        setClear(true);
        return result;        
    }
    public void setRadians(boolean b){
        this.radians = b;
    }
    public boolean getRadians(){
        return radians;
    }
    public void setErrorMessage(String s){
        this.errorMessage = s;
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }
    public void setErrorPrint(boolean b){
        this.errorPrint = b;
    }
    public boolean getErrorPrint(){
        return errorPrint;
    }
            
    //Setters and getters for the message and numbers.

    public String placeNumber(String s) {
        if(clear == true){
           setMessage(""); 
           setClear(false);
           return message;          
    }
        else{
            setMessage(s);
            return message;
        }
        
    }
    
    public void calculate(){//Controlled by the operator indicating which calculation to use.
        double temp = 0;
            switch (getOperator()){
                case 1: //"Multi"
                    temp = (this.getNum1() * this.getNum2());
                    break;
                case 2: //"Division"
                    if(this.num1 == 0){
                        setErrorMessage("First number was a zero! \r\nYou can not devide by zero.");
                        errorPrint = true;
                        return;
                    }
                    if(this.num2 == 0){
                        setErrorMessage("Second number was a zero! \r\nYou can not divide by zero.");
                        errorPrint = true;
                        return;
                    }
                    temp = (this.getNum1() / this.getNum2());                   
                    break;
                case 3://"Addition"
                    temp = (this.getNum1() + this.getNum2());
                    break;
                case 4://"Subtraction"
                    temp = this.getNum1() - this.getNum2();
                    break;
                case 5://"Receprocal"
                    if (this.getNum1() == 0){
                        setErrorMessage("Number was a zero! \r\nCannot divide by zero.");
                        errorPrint = true;
                    }
                    else{
                    temp = (1 / this.getNum1()); 
                    }
                    break;
                case 6://"PowerOf"
                    Math.pow(this.getNum1(), this.getNum2());
                    break;
                case 8://"Factorial"
                    int f;
                    temp = 1;
            
                     if ( this.getNum1() <= 0 || this.getNum1() >= 20 ){// the error meesage says between 0 and 20 but the test data has a valid 0!!!
                        setErrorMessage("Number was " + getNum1() + "! \r\nMust be a positive integer between 0 and 20.");
                        errorPrint = true;
                     }
                     else if(this.getNum1() != (int)this.getNum1() ){// check for decimal.
                        setErrorMessage("Number was " + getNum1() + "! \r\nMust be a positive integer between 0 and 20.");
                        errorPrint = true;
                     }
                     else{
                     for ( f = 1 ; f <= this.getNum1(); f++ )
                         temp = temp * f;
                     }
                    break; 
                case 10: //"Just an equals"
                    temp = this.getNum2();
                    break;
            }
        
        round(temp);
    }
    
    public void calculateTrig(){//Controlled by the operator indicating which calculation to use. 
        
        double temp = 0;
        double a ;//= getNum1();
        if (radians == false){
            a= getNum1();
            a = Math.toRadians(a); System.out.println(a);
            // this converts the double to a radian for the calculation.
        }
        else{
            a = getNum1();
        }
            switch (getOperator()){
                case 11://"sin"
                    temp = java.lang.Math.sin(a);
                break;
                case 12://"cos"
                    temp = java.lang.Math.cos(a);
                break;
                case 13://"tan"
                    temp = java.lang.Math.tan(a);
                break;
                case 14://"asin"
                    temp = java.lang.Math.asin(a);
                break;
                case 15://"acos"
                    temp = java.lang.Math.acos(a);
                break;
                case 16://"atan"
                    temp = java.lang.Math.atan(a);
                break;
            }
        
            round(temp);

    }
    
    public void round (double d){
        
        double temp = d;
        double rounded = 0;
        
            switch (getRounder()){
                case 0:
                    rounded = Math.round(temp *1)/1;
                    break;
                case 1:
                    rounded = Math.round(temp *10)/10.0;
                    break;
                case 2:
                    rounded = Math.round(temp *100)/100.0;
                    break;
                case 3:
                    rounded = Math.round(temp *1000)/1000.0;
                    break;
                case 4:
                    rounded = Math.round(temp *10000)/10000.0;
                    break;
                case 5:
                    rounded = Math.round(temp *10000)/10000.0;
                    break;
                case 6:
                    rounded = Math.round(temp *100000)/100000.0;
                    break;
                case 7:
                    rounded = Math.round(temp *1000000)/1000000.0;
                    break;
                case 8:
                    rounded = Math.round(temp *10000000)/10000000.0;
                    break;
                case 9:
                    rounded = Math.round(temp *100000000)/100000000.0;
                    break;
            }        
            
        if (getRounder() == 0){//converting to whole number
            setResult (Integer.toString((int)rounded));
        }
        else if((rounded == (int)rounded) ){//testing for whole number
            setResult (Integer.toString((int)rounded));
        }
        else{
            setResult (Double.toString(rounded));
        }
        
    }
}
    