package com.example.godric.housingpayer.essence;

import android.content.Context;
import android.net.MailTo;

import com.example.godric.housingpayer.MainFunctionsActivity;
import com.example.godric.housingpayer.data.CardDataSource;
import com.example.godric.housingpayer.data.MyArray;
import com.example.godric.housingpayer.data.ServiceDataSource;

import java.util.ArrayList;

/**
 * Created by godric on 19.05.2016.
 */
public class User {

    private CardDataSource cardSource;
    private ServiceDataSource serviceSource;
    private ArrayList<Card> cards;
    private ArrayList<Period> periods;
    private ArrayList<Service> services;

    public User(Context context) {
        cards = new ArrayList<Card>();
        services = new ArrayList<Service>();
        cardSource = new CardDataSource(context);
        periods = new ArrayList<Period>();
        serviceSource = new ServiceDataSource(context);
        updateData();
    }

    public void addPeriodto(Period p, String service) {
        periods.add(p);
        for (int i = 0; i < services.size(); ++i) {
            if (services.get(i).getName().equals(service)) {
                services.get(i).getPeriod().add(p);
                MainFunctionsActivity.curUser.getServiceSource().updatePeriodOfService(services.get(i));
                break;
            }
        }
    }

    public ServiceDataSource getServiceSource() {
        return this.serviceSource;
    }

    public void pay(String service, String period) {
        int i;
        int id = -1;
        for (i = 0; i < periods.size(); ++i) {
            if (period.equals(periods.get(i).toString())) {
                id = periods.get(i).getId();
                serviceSource.removePeriod(id);
                break;
            }
        }
        periods.remove(i);
        for (Service s: services) {
            for (int j = 0; j < s.getPeriod().size(); ++j) {
                if (s.getPeriod().get(j).getId() == id) {
                    s.getPeriod().remove(j);
                    break;
                }
            }
        }
        upgradeService();
    }

    public void upgradeService() {
        for (Service s : services ) {
            serviceSource.updatePeriodOfService(s);
        }
    }

    public void updateData() {
        cards = cardSource.getAllCards();
        periods = serviceSource.getAllPeriods();
        services = serviceSource.getAllServices();

        for (int i = 0; i < services.size(); ++i) {
            ArrayList<Integer> tmp = MyArray.intArrFromString(services.get(i).getPeriodString(), '|');
            if (!tmp.isEmpty()) {
                for (Integer t : tmp) {
                    services.get(i).getPeriod().add(getPeriodById(t.intValue()));
                }
            }
        }
    }

    public Period getPeriodById(int i) {
        for (Period p : periods) {
            if (p.getId() == i) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<String> getServicesName() {
        ArrayList<String> res = new ArrayList<String>();
        if (!services.isEmpty()) {
            for (Service s : services) {
                res.add(s.getName());
            }
        }
        return res;
    }

    public Service getServiceByName(String name) {
        if (!services.isEmpty()) {
            for (Service s : services) {
                if (name.equals(s.getName())) {
                    return s;
                }
            }
        }
        return null;
    }

    public ArrayList<String> getCardsNumber() {
        ArrayList<String> res = new ArrayList<String>();
        if (!cards.isEmpty()) {
            for (Card s : cards) {
                res.add(s.getNumber());
            }
        }
        return res;
    }

    /////////////////////////////////////

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public ArrayList<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(ArrayList<Period> periods) {
        this.periods = periods;
    }

    public Period getPeriodByName(String choosed) {
        for (Period p : periods) {
            if (p.toString().equals(choosed)) {
                return p;
            }
        }
        return null;
    }
}
