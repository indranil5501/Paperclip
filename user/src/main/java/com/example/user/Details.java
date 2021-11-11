package com.example.user;

public class Details {




        String  shop,  phone, alternative, Address;

    public Details() {

    }

    public Details(  String shop,  String phone, String alternative, String Address) {
            //this.name = name;
            this.shop = shop;
            //this.pincode = pincode;
           // this.service = service;
            this.phone = phone;
            this.alternative = alternative;
            this.Address = Address;
        }

       /** public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }**/

        public String getShop() {
            return shop;
        }

        public void setShop(String shop) {
            this.shop = shop;
        }

       /** public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }**/

      /**  public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }**/

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAlternative() {
            return alternative;
        }

        public void setAlternative(String alternative) {
            this.alternative = alternative;
        }

     public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}


