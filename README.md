# meta-nanopi-neo-air - Meta Layer for Nanopi Neo AIr

This README file contains information on building the meta-nanopi-neo-air BSP layer.
Please see the corresponding sections below for details.

This layer provides:
- Linux 4.11.2 based on FriendlyArm Linux release
- U-Boot 2017.05 based on FriendlyArm U-Boot release

Current status:
1. WiFi Test OK
2. Audio codec Test OK
3. Bluetooth Untested (volunteers requested)

## Dependencies

This layer depends on:

  URI: git://git.yoctoproject.org/poky
  branch: morty
 
  URI: git://git.openembedded.org/meta-openembedded
  branch: morty

  URI: git://github.com/linux-sunxi/meta-sunxi
  branch: master


## Flashing NanoPi image on external SD card
At some moments, you definitely need to push your piece of software on your Pi:
```bash
bitbake core-image-minimal # or whatever image you built
sudo dd if=tmp/deploy/images/nanopi-neo-air/core-image-minimal.sunxi-sdimg of=/dev/sdXXX # XXX is your SD device
```

## Flashing NanoPi image on internal eMMC
The generated image is compatible with both SD card and eMMC.

You had to first boot your device on SD card, then flash the internal eMMC by command line with 'dd'.

You can copy the image on SD card filesystem first, but my preference is to make a direct eMMC copy through the WiFI of the board:
```bash
bitbake core-image-minimal # or whatever image you built
sudo dd if=tmp/deploy/images/nanopi-neo-air/core-image-minimal.sunxi-sdimg | ssh root@<nanopi-ip-address> dd of=/dev/mmcblk3 # <nanopi-ip-address> is your NanoPi IP address
```

## Bluetooth init

This section is untested. I doubt these commands are really needed now.

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

Playback is working with no specific configuration, but capture on Mic1 must be setup first with:
```bash
amixer set Mic1 cap
```

## Wifi init

It works without user intervention, except I observed some init failure when power is coming from the weakly/non-powered USB plug on my laptop.

