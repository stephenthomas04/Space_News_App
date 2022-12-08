package com.example.hamburgertester;

import java.util.ArrayList;

public class Satellite {

     ArrayList<Above> above;

     public Satellite(ArrayList<Above> above) {
          this.above = above;
     }

     public ArrayList<Above> getAbove() {
          return above;
     }

     public void setAbove(ArrayList<Above> above) {
          this.above = above;
     }
}

class Above{
     String satname;
     String satlat;
     String satlng;
     String satalt; //In order for api
     String launchDate;


     public Above(String satname, String satlat, String satlng, String satalt, String launchDate) {
          this.satname = satname;
          this.satlat = satlat;
          this.satlng = satlng;
          this.satalt = satalt;
          this.launchDate = launchDate;
     }

     public String getLaunchDate() {
          return launchDate;
     }

     public void setLaunchDate(String launchDate) {
          this.launchDate = launchDate;
     }

     public String getSatname() {
          if(satname.length() >= 18){
               satname = satname.substring(0,18);
          }
          return satname;
     }

     public void setSatname(String satname) {
          this.satname = satname;
     }

     public String getSatlat() {
          return satlat;
     }

     public void setSatlat(String satlat) {
          this.satlat = satlat;
     }

     public String getSatlng() {
          return satlng;
     }

     public void setSatlng(String satlng) {
          this.satlng = satlng;
     }

     public String getSatalt() {
          return satalt;
     }

     public void setSatalt(String satalt) {
          this.satalt = satalt;
     }


}


      /*
        THIS IS THE REFERENCE

        {
  "info": {
    "satname": "SPACE STATION",
    "satid": 25544,
    "transactionscount": 5
  },
  "positions": [
    {
      "satlatitude": -39.90318514,
      "satlongitude": 158.28897924,
      "sataltitude": 417.85,
      "azimuth": 254.31,
      "elevation": -69.09,
      "ra": 44.77078138,
      "dec": -43.99279118,
      "timestamp": 1521354418
    },
    {
      "satlatitude": -39.86493451,
      "satlongitude": 158.35261287,
      "sataltitude": 417.84,
      "azimuth": 254.33,
      "elevation": -69.06,
      "ra": 44.81676119,
      "dec": -43.98086419,
      "timestamp": 1521354419
    }
  ]
}
         */


