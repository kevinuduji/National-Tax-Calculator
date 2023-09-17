import java.util.*;

class TaxCalculator
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Choosing your current state
        System.out.println("What state are you referencing.\n(If you don't enter a state or spell it correctly your sales tax will return as 0%):");
        String state = scan.nextLine();
        state = state.toLowerCase();

        //The amount of money you have
        System.out.println("What is your current balance (money you have on you or willing to spend)?:");
        double balance = scan.nextDouble();

        //Number of items in the cart
        System.out.println("How many items are in your shopping cart?");
        int numOfItems = scan.nextInt();
        double[] cart = new double[numOfItems];
        double cartPrice = 0;

        //Calculating the price of the object
        System.out.println("Please enter the retail prices of your items:");
        int count = 1;
        for(int i = 0; i<numOfItems; i++)
        {
            System.out.println("Item #" + count + ":");
            count++;
            cart[i] = scan.nextDouble();
            cartPrice += cart[i];
        }

        System.out.println("Any additional charges(Ex. Shipping or Booking fee)\nEnter 0 if there's none:");
        double shipping = scan.nextDouble();

        System.out.println("Do you have a discount(Ex. 10% Off = 10\nEnter 0 if there's none:)");
        double discount = scan.nextDouble();
        double discountedAmount = (discount/100) * cartPrice;

        cartPrice = cartPrice + shipping - discountedAmount;

        double tax; 
        double salesTax;

        //All 50 States including Puerto Rico
        switch(state)
        { 
            case "alabama":
            salesTax = .04;
                break;
            case "alaska":
            salesTax = .00;
                break;
            case "arizona":
            salesTax = .056;
                break;    
            case "arkansas":
            salesTax = .065;
                break;
            case "california":
            salesTax = .0725;
                break;
            case "colorado":
            salesTax = .029;
                break;               
            case "connecticut":
            salesTax = .0635;
                break;
            case "delaware":
            salesTax = .00;
                break;
            case "florida":
            salesTax = .06;
                break;
            case "georgia":
            salesTax = .04;
                break;
            case "hawaii":
            salesTax = .04;
                break;
            case "idaho":
            salesTax = .06;
                break;
            case "illinois":
            salesTax= .0625;
                break;    
            case "indiana":
            salesTax = .07;
                break;
            case "iowa":
            salesTax = .06;
                break;
            case "kansas":
            salesTax = .065;
                break;
            case "kentucky":
            salesTax = .06;
                break;
            case "louisiana":
            salesTax = .0445;
                break;    
            case "maine":
            salesTax = .055;
                break;
            case "maryland":
            salesTax = .06;
                break;
            case "massachusetts":
            salesTax = .0625;
                break;
            case "michigan":
            salesTax = .06;
                break;
            case "minnestota":
            salesTax = .06875;
                break;    
            case "mississippi":
            salesTax = .07;
                break;
            case "missouri":
            salesTax = .04225;
                break;
            case "montana":
            salesTax = .0;
                break;
            case "nebraska":
            salesTax = .055;
                break;
            case "nevada":
            salesTax = .0685;
                break;    
            case "new hampshire":
            salesTax = .0;
                break;
            case "new jersey":
            salesTax = .06625;
                break;
            case "new mexico":
            salesTax = .05125;
                break;
            case "new york":
            salesTax = .04;
                break;
            case "north carolina":
            salesTax = .04750;
                break;    
            case "north dakota":
            salesTax = .05;
                break;
            case "ohio":
            salesTax = .0575;
                break;
            case "oklahoma":
            salesTax = .045;
                break;
            case "oregon":
            salesTax = .0;
                break;
            case "pennsylvania":
            salesTax = .06;
                break;    
            case "puerto rico":
            salesTax = .115;
                break;
            case "rhode island":
            salesTax = .07;
                break;
            case "south carolina":
            salesTax = .06;
                break;
            case "south dakota":
            salesTax = .045;
                break;
            case "tennessee":
            salesTax = .07;
                break;    
            case "texas":
            salesTax = .0825;// For anyone looking this up this is a more accurate nummber for TX
                break;
            case "utah":
            salesTax = .04850;
                break;
            case "vermont":
            salesTax = .06;
                break;
            case "virginia":
            salesTax = .043;
                break;
            case "washington" :
            salesTax = .065;
                break;    
            case "west virginia":
            salesTax = .06;
                break;
            case "wisconsin":
            salesTax = .05;
                break; 
            case "wyoming":
            salesTax = .04;
                break;  
            default:
            salesTax = 0;
                break;    
        }
        
        //Calculates tax using the price
        tax = cartPrice * salesTax;//0.0825;
        double total = (1+salesTax) * cartPrice;

        double leftOverBalance = balance - total;

        //Final Output
        if (leftOverBalance < 0 )
        {
            System.out.println("You're too broke, I'm sorry 😢..." );
            System.out.println("Total: $" + total);
            System.out.println("You need to save up $" + (leftOverBalance*-1) + " more.");
        }
        else
        {
            System.out.println("\nBuy away 😁!!!");
            if(discount>0)
            {
                System.out.println("Discount: " + String.format("%.0f",discount) + "% Off");
                System.out.println("You Saved: $" + String.format("%.2f",discountedAmount));
            }
            System.out.println("Total: $" + String.format("%.2f",total));
            System.out.println("You have $" + String.format("%.2f",leftOverBalance) + " remaining!\n");
        }
	}
}