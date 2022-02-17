package com.spring.example.springdemo.libraries;

public class Enums {
    public enum CreationObjects {
        individual_file("someFile.json"),
        individual_Uri("http://www.google.co.uk");
        private String value;

        CreationObjects(String value) {
            this.value = value;
        }

        public String getIndividuaslFile()
        {
            return value;
        }

        public String getIndividualUri(){
            return value;
        }
    }
}
