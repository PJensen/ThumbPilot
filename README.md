#Thumb-Pilot
1. Development
[Install Android SDK] http://dl.google.com/android/android-sdk_r07-windows.zip
[Install Eclipse] http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/heliosr
[Install Eclipse Plugin] http://developer.android.com/sdk/eclipse-adt.html
   1.  Start Eclipse, then select Help > Install New Software.
   2. In the Available Software dialog, click Add....
   3. In the Add Site dialog that appears, enter a name for the remote site (for example, "Android Plugin") in the "Name" field.

      In the "Location" field, enter this URL:

      https://dl-ssl.google.com/android/eclipse/

      Note: If you have trouble acquiring the plugin, you can try using "http" in the URL, instead of "https" (https is preferred for security reasons).

      Click OK.
   4. Back in the Available Software view, you should now see "Developer Tools" added to the list. Select the checkbox next to Developer Tools, which will automatically select the nested tools Android DDMS and Android Development Tools. Click Next.
   5. In the resulting Install Details dialog, the Android DDMS and Android Development Tools features are listed. Click Next to read and accept the license agreement and install any dependencies, then click Finish.
   6. Restart Eclipse.

* Finally, import project into workspace using Eclipse *

2. Gameplay

**To be continued ...**

#Elements:

##Bonuses; when collected can:
  a. Kill all enemies on screen
  b. Provide a massive amount of points
  c. Heal
  d. Ammo?

##Enemies; come in several types:
  a. aggressive
  b. kill bonuses
  c. spawn others
  d. dumb
  
##Lives:
  The player has a limited number of lives.
  The player can loose points when striking an enemy?
  The player can loose lives when striking an enemy.

# Design
 1. Various enemies and bonuses need some graphics; not exactly sure what yet.
 2. Smoke trails have been done in the proof of concept.
 3. Bitmaps once loaded can been scaled, skewed, shifted, rotated! ** more info to come**


