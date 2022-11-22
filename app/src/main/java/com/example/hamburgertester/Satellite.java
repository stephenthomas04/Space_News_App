package com.example.hamburgertester;

public class Satellite {
    // https://api.n2yo.com/rest/v1/satellite/above/41.702/-76.014/0/70/18/&apiKey=ULABLY-ZTED3R-TZA269-4YF2

     //https://www.geeksforgeeks.org/how-to-extract-data-from-json-array-in-android-using-volley-library/

     private String name;
     private String satLatitude;
     private String satLongitude;
     private String satAltitude;



     public Satellite(String name, String satLatitude, String satLongitude, String satAltitude) {
          this.name = name;
          this.satLatitude = satLatitude;
          this.satLongitude = satLongitude;
          this.satAltitude = satAltitude;

     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getSatLatitude() {
          return satLatitude;
     }

     public void setSatLatitude(String satLatitude) {
          this.satLatitude = satLatitude;
     }

     public String getSatLongitude() {
          return satLongitude;
     }

     public void setSatLongitude(String satLongitude) {
          this.satLongitude = satLongitude;
     }

     public String getSatAltitude() {
          return satAltitude;
     }

     public void setSatAltitude(String satAltitude) {
          this.satAltitude = satAltitude;
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
}

