from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import time


device = MonkeyRunner.waitForConnection()

package = "com.computemachines.audiotransform"
finderActivity = ".FinderActivity"

result = device.takeSnapshot()
result.writeToFile("system_initial.png" % (n), "png")

for n in range(25):
    print "current time: "+str(time.localtime())
    if n == 5:
        device.startActivity(component=package+"/"+finderActivity)
    if n == 10:
        # tap in center region
        device.touch(300, 500, MonkeyDevice.DOWN_AND_UP)
    if n == 15:
        result = device.takeSnapshot()
        result.writeToFile("activity_finder.png" % (n), "png")
    time.sleep(60)
