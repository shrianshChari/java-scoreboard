# Java Scoreboard v1.3.1

This is a Java-based scoreboard for use in Open Broadcaster Software as a Score Board (in the vein of Score Board Edit by Zou).

It was initially built as a way for people unable to run SBE on their device (as it is based on the .NET framework), and as a way for me to practice programming Java. As such, the code is incomplete and can be improved.

It is primarily for use in streaming fighting game tournaments, and lets you change the score in the match, or change the players' names in between matches very easily.

## Changelog (from v1.3.02)
- Updated comments to show what each function actually does
- Renamed "Misc" and "Label" to "Tournament Name" and "Tournament Round"

## Prerequisites

Your computer should be running the latest version of the Java Development Kit to run this program. To check if you are running the latest JDK, enter the following command in your computer's command line:

```bash
javac -version
```

## Usage

### Windows

If you are running a Windows system, enter `Windows/Scoreboard` and execute `scoreboard.exe`.

Running the program will create the output folder as well as all of the necessary files in `Windows/Output`.

### Other Platforms

If you are running macOS, \*nix, or any other operating system, enter `Other Platforms/Scoreboard` and execute `scoreboard.jar`.

Running the program will create the output folder as well as all of the necessary files in `Other Platforms/Output`.

### Interaction with OBS

In OBS, in your scene, add a new text source. In its properties (which will probably pop up after you've created it), check the `Read from file` option. Then browse your files until you find the `Output` folder containing your files. Choose the TXT file you want OBS to read from and the text in OBS will automatically update as you update the TXT file.

### Interaction with Xsplit
Make sure that your Text plugin is updated by going into `Tools → My Plugins`.

Then, you add a Text source, check mark `Use Custom Script` and click the button labeled `Edit Script`. Make sure the template is set to `Load Text from Local File` and set the path to the TXT file of your choice and the text in XSplit will automatically update as you update the TXT file.

## What is there currently:

- Can support a name, score, and sponsor of two players, along with the tournament name/round

## To-do
- Add extra text boxes for "miscellaneous" and "label" files
- Being able to browse the user's computer to store the output files
