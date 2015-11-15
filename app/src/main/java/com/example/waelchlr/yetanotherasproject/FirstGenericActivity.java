package com.example.waelchlr.yetanotherasproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.opencv.android.Utils;
import org.opencv.core.DMatch;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.imgcodecs.*;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;

public class FirstGenericActivity extends AppCompatActivity {

    //required to use openCV Library
    static {System.loadLibrary("opencv_java3");}

    //declare the reference image array
    private static Integer[] referenceImages = new Integer[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_generic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //method to populate the reference image array with interger ids
    private void populateReferenceImagesArray(){
        referenceImages[0] = R.drawable.testimageone;
        referenceImages[1] = R.drawable.testimagetwo;
        referenceImages[2] = R.drawable.testimagethree;
        referenceImages[3] = R.drawable.testimageone;
        referenceImages[4] = R.drawable.testimagefive;
        referenceImages[5] = R.drawable.testimagesix;
        referenceImages[6] = R.drawable.testimageseven;
        referenceImages[7] = R.drawable.testimageeight;
    }

    //image four button listener
    public void imageFourListener(View v){
         attemptMatch();
    }

    //method that performs the match
    public void attemptMatch(){

        double matchPercent=10;
        int a=0;

        //populate reference image array
        populateReferenceImagesArray();

        MatOfKeyPoint k1 = new MatOfKeyPoint();
        Mat d1 = new Mat();
        FeatureDetector detector = FeatureDetector.create(FeatureDetector.ORB);
        DescriptorExtractor extractor = DescriptorExtractor.create(DescriptorExtractor.ORB);
        DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_HAMMING);
        MatOfDMatch matches = new MatOfDMatch();

        //define application context
        Context newContext=getApplicationContext();

        try{

            //load the sample image from the drawable directory
            Mat img1 = Utils.loadResource(newContext, R.drawable.testimagefour, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

            //Detect the key features of the image
            detector.detect(img1, k1);

            //Extract descriptors from the image
            extractor.compute(img1, k1, d1);

            //Begin loop for matching
            while (matchPercent<40){

                //initialize counter
                int b=0;

                //load reference image
                Mat img2=Utils.loadResource(newContext, referenceImages[a], Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

                //Initialize key features matrix
                MatOfKeyPoint k2 = new MatOfKeyPoint();

                //Initialize descriptor matrix
                Mat d2 = new Mat();

                //Detect the key features of the reference images
                detector.detect(img2, k2);

                //Extract the descriptors from the image
                extractor.compute(img2, k2, d2);

                //Match points of two images
                matcher.match(d1,d2,matches);

                List<DMatch> matchesDMatch = matches.toList();
                ArrayList<Float> goodMatches = new ArrayList<>();

                while (b<matches.height()){

                    int c=Math.round(matchesDMatch.get(b).distance);
                    if (c<55){
                        goodMatches.add(matchesDMatch.get(b).distance);
                    }

                    b=b+1;

                }

                //Advance through the reference photo array
                a=a+1;
                matchPercent=goodMatches.size();

            }

            System.out.println("\nBest Match is reference image "+a);

        }catch(IOException e){
            System.out.println("IOException Thrown and Caught:  " + e);
        }

    }

}