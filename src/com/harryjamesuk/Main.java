package com.harryjamesuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String userInput;

    static float charge_proton = (float) 1.60e-19;
    static float charge_neutron = 0;
    static float charge_electron = (float) -1.60e-19;

    static float mass_proton = (float) 1.673e-27;
    static float mass_neutron = (float) 1.675e-27;
    static float mass_electron = (float) 9.11e-31;

    static int numOfProtons;
    static int numOfNeutrons;
    static int numOfElectrons;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // I/O
        try {
            System.out.println("Enter the number of protons: ");
            numOfProtons = Integer.parseInt(br.readLine());
            System.out.println("Enter the number of neutrons: ");
            numOfNeutrons = Integer.parseInt(br.readLine());
            System.out.println("Enter the number of electrons (" + numOfProtons + "):");
            userInput = br.readLine();
            numOfElectrons = checkDefault(userInput);
            System.out.println("---");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }

        // Calculation

        float overallCharge;
        if (numOfProtons != numOfElectrons) {
            // Ion.
            // Determine whether we have a positive or negative ion.
            if (numOfProtons < numOfElectrons) {
                // Negative ion. More electrons than protons.
                overallCharge = (numOfElectrons - numOfProtons) * charge_electron;
                // Positive * negative.
            } else {
                // Positive ion. More protons than electrons.
                overallCharge = (numOfProtons - numOfElectrons) * charge_proton;
            }
        } else {
            // Positive charge.
            overallCharge = (numOfProtons * charge_proton);
        }

        float overallMass = (numOfProtons * mass_proton) + (numOfNeutrons * mass_neutron) + (numOfElectrons * mass_electron);

        float specificCharge = (overallCharge)/(overallMass);
        System.out.println("Specific charge: " + specificCharge);
    }

    private static int checkDefault(String userInput) {
        if (userInput.equals("")) {
            System.out.println(numOfProtons);
            return numOfProtons;
        } else {
            return Integer.parseInt(userInput);
        }
    }
}
