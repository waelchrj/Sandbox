package com.example.waelchlr.yetanotherasproject;

/**
 * Created by waelchlr on 11/15/2015.
 */
public class ReferenceDatabase {

    //declare the reference image array
    public Integer[][] referenceImages=new Integer[8][2];

    public void populate(){

        //populate the reference image array
        this.referenceImages[0][0] = R.raw.testimageone;
        this.referenceImages[0][1] = 100;
        this.referenceImages[1][0] = R.raw.testimagetwo;
        this.referenceImages[1][1] = 200;
        this.referenceImages[2][0] = R.raw.testimagethree;
        this.referenceImages[2][1] = 300;
        this.referenceImages[3][0] = R.raw.testimageone;
        this.referenceImages[3][1] = 300;
        this.referenceImages[4][0] = R.raw.testimagefive;
        this.referenceImages[4][1] = 300;
        this.referenceImages[5][0] = R.raw.testimagesix;
        this.referenceImages[5][1] = 300;
        this.referenceImages[6][0] = R.raw.testimageseven;
        this.referenceImages[6][1] = 400;
        this.referenceImages[7][0] = R.raw.testimageeight;
        this.referenceImages[7][1] = 500;

    }

    public String askMeANumberAndIllGiveYouAString(Integer i){
        String buildingName;

        switch (i){

            case 100: buildingName="Chrysler Building";
                break;
            case 200: buildingName="Sears Tower";
                break;
            case 300: buildingName="Lehman Building";
                break;
            case 400: buildingName="Welcome Center";
                break;
            case 500: buildingName="College of Arts and Sciences";
                break;
            default: buildingName="Building Not Found";
                break;
        }

        return buildingName;
    }
}

