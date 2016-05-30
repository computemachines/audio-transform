from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

device = MonkeyRunner.waitForConnection()

package = "com.computemachines.audiotransform"
finderActivity = ".FinderActivity"


device.startActivity(component=package+"/"+finderActivity)
result = device.takeSnapshot()
result.writeToFile("activity_finder.png", "png")
