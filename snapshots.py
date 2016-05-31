from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import time


device = MonkeyRunner.waitForConnection()

package = "com.computemachines.audiotransform"
finderActivity = ".FinderActivity"

for n in range(5):
    print "taking snapshot at "+str("(time.localtime()")
    # device.startActivity(component=package+"/"+finderActivity)
    result = device.takeSnapshot()
    result.writeToFile("activity_finder_%02d.png" % (n), "png")
    time.sleep(60)
