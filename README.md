# meta-nanopi-neo-air - Meta Layer for Nanopi Neo AIr

For use with

- poky morty
- meta-openembedded morty
- meta-sunxi master 
- Linux 4.11.2

WiFi Tested
Audio Untested

## Bluetooth Init

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
