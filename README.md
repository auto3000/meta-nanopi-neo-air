# meta-nanopi-neo-air - Meta Layer for Nanopi Neo AIr

For use with

- poky morty
- meta-openembedded morty
- meta-sunxi master 
- Linux 4.11.2 (based on FriendlyArm Linux release)

Current status:
1. WiFi Test OK
2. Audio codec Test OK
3. Bluetooth Untested

## Flashing NanoPi image on SD card
At some moments, you definitely need to push your piece of software on your Pi:
```bash
bitbake core-image-minimal # or whatever image you built
sudo dd if=tmp/deploy/images/nanopi-neo-air/core-image-minimal.sunxi-sdimg of=/dev/sdXXX # XXX is your SD device
```

## Bluetooth init

```bash
/etc/init.d/bluetooth start

echo 205 > /sys/class/gpio/export # BT-RESET
echo 8 > /sys/class/gpio/export # BT-WAKE

echo out > /sys/class/gpio/gpio205/direction
echo out > /sys/class/gpio/gpio8/direction

echo -n " " > /dev/ttyS3

sleep 1

echo 0 > /sys/class/gpio/gpio205/value && echo 1 > /sys/class/gpio/gpio205/value

sleep 1

echo -n " " > /dev/ttyS3

cat /proc/tty/driver/serial 

sleep 1

brcm_patchram_plus -d  --patchram /etc/firmware/ap6212/4343A0.hcd --bd_addr 11:22:33:44:55:66 --no2bytes --tosleep 1000 /dev/ttyS3

sleep 1

hciattach /dev/ttyS3 any
hciconfig hci0 up
```

## Audio codec init

Capture on Mic1 can be started with:
```bash
amixer set Mic1 cap
```

## Wifi init

It works without user intervention, except I observed some init failure when power is coming from the weakly/non-powered USB plug on my laptop.

