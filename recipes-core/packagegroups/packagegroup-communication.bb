DESCRIPTION = "Communication package, WiFi, BT, etc"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = "\
    linux-firmware \
    iw \
    wireless-tools \ 
    wpa-supplicant \
    wpa-supplicant-cli \
    wpa-supplicant-passphrase \
    dhcpcd \
    hostapd \
    bluez5 \
    packagegroup-tools-bluetooth \
    brcm-patchram-plus \
"
