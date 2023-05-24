package tests.practice_BabayigitHoca;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class P01 {

        @Test(priority = 10)
        public void Didem() {
            System.out.println("Didem");
        }

        @Test(enabled = false)
        public void Zeynep() {
            System.out.println("Zeynep");

        }

        @Test(priority = -5)
        public void Kadir() {
            System.out.println("H.Kadir");
        }

        @Test(dependsOnMethods = "Kerem")
        public void Erdal() {
            System.out.println("Erdal");
        }

        @Test
        public void Kerem() {
            System.out.println("Kerem");
        }

        @Test(dependsOnMethods = "Bulent")
        public void Nur() {
            System.out.println("Nur");
        }

        @Test
        public void Bulent() {
            System.out.println("Bulent");

        }
    }

