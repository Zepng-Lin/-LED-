import sys
import RPi.GPIO as GPIO
import time


def led(msg):
	channel = 16
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(channel, GPIO.OUT,initial = GPIO.HIGH)
	if msg == "1":
        	GPIO.output(channel,GPIO.HIGH)
        	print "led is trun on"
    	elif msg == "0":
        	GPIO.output(channel,GPIO.LOW)
        	print "led is trun off"

if __name__ == '__main__':
	led(sys.argv[1])

