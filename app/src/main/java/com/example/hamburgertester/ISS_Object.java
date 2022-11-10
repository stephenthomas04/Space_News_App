package com.example.hamburgertester;

public class ISS_Object {

    private double longitude;
    private double latitude;
    private double iss_position[];

    public ISS_Object(int longitude, int latitude, double[] iss_position){
            longitude = longitude;
            latitude = latitude;
            iss_position = iss_position;
    }

    public double[] getIss_position() {
            return iss_position;
        }

        public void setIss_position(double[] iss_position) {
            this.iss_position = iss_position;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        @Override
        public String toString() {
            return "ISS{" +
                    "longitude=" + longitude +
                    ", latitude=" + latitude +
                    '}';
        }

}
