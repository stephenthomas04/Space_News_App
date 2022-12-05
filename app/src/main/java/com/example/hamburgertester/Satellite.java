package com.example.hamburgertester;

import java.util.ArrayList;

public class Satellite {
    // https://api.n2yo.com/rest/v1/satellite/above/41.702/-76.014/0/70/18/&apiKey=ULABLY-ZTED3R-TZA269-4YF2

     //https://www.geeksforgeeks.org/how-to-extract-data-from-json-array-in-android-using-volley-library/


     public String satname;
     public double satlat;
     public double satlng;
     public double satalt; //In order for api

     public Satellite(String satname, double satlat, double satlng, double satalt) {
          this.satname = satname;
          this.satlat = satlat;
          this.satlng = satlng;
          this.satalt = satalt;
     }

     public String getSatname() {
          return satname;
     }

     public void setSatname(String satname) {
          this.satname = satname;
     }

     public double getSatlat() {
          return satlat;
     }

     public void setSatlat(double satlat) {
          this.satlat = satlat;
     }

     public double getSatlng() {
          return satlng;
     }

     public void setSatlng(double satlng) {
          this.satlng = satlng;
     }

     public double getSatalt() {
          return satalt;
     }

     public void setSatalt(double satalt) {
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


