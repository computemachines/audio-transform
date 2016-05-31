from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import time


device = MonkeyRunner.waitForConnection()

package = "com.computemachines.audiotransform"
finderActivity = ".FinderActivity"

for _ in range(5):
    print "taking snapshot at {}".format(time.localtime())
    # device.startActivity(component=package+"/"+finderActivity)
    result = device.takeSnapshot()
    result.writeToFile("activity_finder.png", "png")
    time.sleep(60)
