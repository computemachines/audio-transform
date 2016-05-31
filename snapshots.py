from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import time


device = MonkeyRunner.waitForConnection()

package = "com.computemachines.audiotransform"
finderActivity = ".FinderActivity"

for n in range(25):
    print "taking snapshot at "+str(time.localtime())
    if n == 5:
        device.startActivity(component=package+"/"+finderActivity)
    if n == 10:
        # tap in center of device
        device.wake()
    result = device.takeSnapshot()
    result.writeToFile("activity_finder_%02d.png" % (n), "png")
    time.sleep(60)
