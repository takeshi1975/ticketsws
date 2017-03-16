package com.epl.tickets.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcortes on 09/03/2017.
 */
public class Purchase implements Serializable {

    public String firstname;


    public String lastname;

    public String email;

    public String telephone;

    public String countryCode;

    public String countrySubdivisionCode;

    public List<TicketOrder> ticketOrders = new ArrayList<>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountrySubdivisionCode() {
        return countrySubdivisionCode;
    }

    public void setCountrySubdivisionCode(String countrySubdivisionCode) {
        this.countrySubdivisionCode = countrySubdivisionCode;
    }

    public List<TicketOrder> getTicketOrders() {
        return ticketOrders;
    }

    public void setTicketOrders(List<TicketOrder> ticketOrders) {
        this.ticketOrders = ticketOrders;
    }




    public static class TicketOrder{


        public String idSession;

        public String numseat;

        public String idActivity;

        public String getIdSession() {
            return idSession;
        }

        public void setIdSession(String idSession) {
            this.idSession = idSession;
        }

        public String getIdActivity() {
            return idActivity;
        }

        public void setIdActivity(String idActivity) {
            this.idActivity = idActivity;
        }

        public String getNumseat() {
            return numseat;
        }

        public void setNumseat(String numseat) {
            this.numseat = numseat;
        }




    }


}
