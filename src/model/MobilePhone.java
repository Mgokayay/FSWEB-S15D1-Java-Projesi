package model;

import java.util.ArrayList;

public class MobilePhone {
    private String myPhone;
    private ArrayList<Contact> contacts;

    public MobilePhone(String myPhone) {
        this.myPhone = myPhone;
        this.contacts=new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (contact == null || contact.getName() == null || contact.getPhoneNumber()==null){
            return false;
        }
        if(findContact(contact.getName()) >= 0) {
            return false;
        }
        this.contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact,Contact newContact) {
        int oldContactIndex = findContact(oldContact);
        if(oldContactIndex<0) {
            return false;
        }
         this.contacts.set(oldContactIndex,newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if(findContact(contact) < 0) {
            return false;
        }
        this.contacts.remove(contact);
        return  true;
    }

    public Contact queryContact(String contactName) {
        int contactIndex = findContact(contactName);
        if(contactIndex<0) {
            return null;
        }
        return this.contacts.get(contactIndex);

    }

    public void printContacts(){

        contacts.forEach((contact) ->System.out.println((contacts.indexOf(contact)+1)+ "->" + contact.getName() + "->" + contact.getPhoneNumber() ));

    }

    public int findContact(String name) {
        for(int i=0; i<contacts.size() ;i++){
            Contact contact= contacts.get(i);
            if(contacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;

    }
    private int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }


}
