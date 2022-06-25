import java.util.Enumeration;

public class HtmlStatement extends Statement {

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = getHeader(aCustomer);
        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           //show figures for each rental
           result += getRentalFigures(each);
        }
        //add footer lines
        result += getFooter(aCustomer);
        return result;
    }

    public String getHeader(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() +
        "</EM></H1><P>\n";
    }

    public String getRentalFigures(Rental aRental) {
        return aRental.getMovie().getTitle()+ ": " +
        String.valueOf(aRental.getCharge()) + "<BR>\n";
    }

    public String getFooter(Customer aCustomer) {
        String result = "<P>You owe <EM>" +
        String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + 
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        "</EM> frequent renter points<P>"; 
        return result;
    }

}