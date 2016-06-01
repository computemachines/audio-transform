from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import time


device = MonkeyRunner.waitForConnection()

package = "com.computemachines.audiotransform"
finderActivity = ".FinderActivity"

result = device.takeSnapshot()
result.writeToFile("system_initial.png", "png")

for n in range(16):
    print "current time: "+str(time.localtime())
    if n == 5:
        print "starting activity"
        device.startActivity(component=package+"/"+finderActivity)
    if n == 10:
        print "touching center"
        # tap in center region
        device.touch(300, 500, MonkeyDevice.DOWN_AND_UP)
    if n == 15:
        print "taking snapshot"
        result = device.takeSnapshot()
        result.writeToFile("activity_finder.png", "png")
    time.sleep(60)
