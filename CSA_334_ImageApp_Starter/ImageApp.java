/*
  ImageApp: 
 */
import java.awt.Color;

public class ImageApp
{
  public static void main(String[] args)
  {

    // use any file from the lib folder
    String pictureFile = "lib/beach.jpg";

    // Get an image, get 2d array of pixels, show a color of a pixel, and display the image
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

    // Reorder RGB to BRG (Blue, Red, Green)
    for (int row = 0; row < recoloredPixels.length; row++) {
      for (int col = 0; col < recoloredPixels[0].length; col++) {
        Color originalColor = recoloredPixels[row][col].getColor();
        int red = originalColor.getRed();
        int green = originalColor.getGreen();
        int blue = originalColor.getBlue();
        Color newColor = new Color(blue, red, green); // BRG order
        recoloredPixels[row][col].setColor(newColor);
      }
    }
    recoloredImg.explore();

    // Image #2 Using the original image and pixels, create a photographic negative of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();

    // Create negative by subtracting each RGB value from 255
    for (int row = 0; row < negPixels.length; row++) {
      for (int col = 0; col < negPixels[0].length; col++) {
        Color originalColor = negPixels[row][col].getColor();
        int red = originalColor.getRed();
        int green = originalColor.getGreen();
        int blue = originalColor.getBlue();
        Color negativeColor = new Color(255 - red, 255 - green, 255 - blue);
        negPixels[row][col].setColor(negativeColor);
      }
    }
    negImg.explore();

    // Image #3 Using the original image and pixels, create a grayscale version of the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();

    // Convert to grayscale by averaging RGB values
    for (int row = 0; row < grayscalePixels.length; row++) {
      for (int col = 0; col < grayscalePixels[0].length; col++) {
        Color originalColor = grayscalePixels[row][col].getColor();
        int red = originalColor.getRed();
        int green = originalColor.getGreen();
        int blue = originalColor.getBlue();
        int average = (red + green + blue) / 3;
        Color grayColor = new Color(average, average, average);
        grayscalePixels[row][col].setColor(grayColor);
      }
    }
    grayscaleImg.explore();

    // Image #4 Using the original image and pixels, rotate it 180 degrees
    Picture upsidedownImage = new Picture(pictureFile);
    Pixel[][] upsideDownPixels = upsidedownImage.getPixels2D();

    // Create a temporary copy to hold the original pixels
    Pixel[][] origPixelsCopy = new Pixel[upsideDownPixels.length][upsideDownPixels[0].length];
    for (int row = 0; row < upsideDownPixels.length; row++) {
      for (int col = 0; col < upsideDownPixels[0].length; col++) {
        origPixelsCopy[row][col] = upsideDownPixels[row][col];
      }
    }

    // Rotate 180 degrees: reverse rows and columns
    for (int row = 0; row < upsideDownPixels.length; row++) {
      for (int col = 0; col < upsideDownPixels[0].length; col++) {
        int newRow = upsideDownPixels.length - 1 - row;
        int newCol = upsideDownPixels[0].length - 1 - col;
        upsideDownPixels[newRow][newCol] = origPixelsCopy[row][col];
      }
    }
    upsidedownImage.explore();

    // Image #5 Using the original image and pixels, rotate image 90
    Picture rotateImg = new Picture(pictureFile);
    Pixel[][] rotatePixels = rotateImg.getPixels2D();

    // Load the original image pixels
    Picture origImg90 = new Picture(pictureFile);
    Pixel[][] origPixels90 = origImg90.getPixels2D();
    int origHeight = origPixels90.length;
    int origWidth = origPixels90[0].length;

    // Fill rotated image with white first
    Color white = new Color(255, 255, 255);
    for (int row = 0; row < rotatePixels.length; row++) {
      for (int col = 0; col < rotatePixels[0].length; col++) {
        rotatePixels[row][col].setColor(white);
      }
    }

    // Rotate 90 degrees clockwise: new[col][height-1-row] = old[row][col]
    for (int row = 0; row < origHeight; row++) {
      for (int col = 0; col < origWidth; col++) {
        int newRow = col;
        int newCol = origHeight - 1 - row;
        // Only set if within bounds
        if (newRow < rotatePixels.length && newCol < rotatePixels[0].length) {
          rotatePixels[newRow][newCol].setColor(origPixels90[row][col].getColor());
        }
      }
    }
    rotateImg.explore();

    // Image #6 Using the original image and pixels, rotate image -90
    Picture rotateImg2 = new Picture(pictureFile);
    Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

    // Load the original image pixels
    Picture origImg270 = new Picture(pictureFile);
    Pixel[][] origPixels270 = origImg270.getPixels2D();
    int origHeight270 = origPixels270.length;
    int origWidth270 = origPixels270[0].length;

    // Fill rotated image with white first
    for (int row = 0; row < rotatePixels2.length; row++) {
      for (int col = 0; col < rotatePixels2[0].length; col++) {
        rotatePixels2[row][col].setColor(white);
      }
    }

    // Rotate 270 degrees clockwise (-90): new[width-1-col][row] = old[row][col]
    for (int row = 0; row < origHeight270; row++) {
      for (int col = 0; col < origWidth270; col++) {
        int newRow = origWidth270 - 1 - col;
        int newCol = row;
        // Only set if within bounds
        if (newRow < rotatePixels2.length && newCol < rotatePixels2[0].length) {
          rotatePixels2[newRow][newCol].setColor(origPixels270[row][col].getColor());
        }
      }
    }
    rotateImg2.explore();


    // Final Image: Add a small image to a larger one

    /* to be implemented */




    // for testing  2D algorithms
    int[][] test1 = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    int[][] test2 = new int[4][4];


  }
}
