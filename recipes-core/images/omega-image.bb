SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

FIRMWARE_INSTALL = " \
    linux-firmware-brcm43438 \
"

SYSTEM_TOOLS_INSTALL = " \
    i2c-tools \
    cpuburn-neon \
    memtester \
    sysbench \
"

DEV_TOOLS_INSTALL = " \
"

NETWORK_TOOLS_INSTALL = " \
"

MEDIA_TOOLS_INSTALL = " \
"

GRAPHICS_LIBS = " \
"  

UTILITIES_INSTALL = " \
    coreutils \
"
 
IMAGE_INSTALL += " \
    ${FIRMWARE_INSTALL} \
    ${SYSTEM_TOOLS_INSTALL} \
    ${DEV_TOOLS_INSTALL} \
    ${NETWORK_TOOLS_INSTALL} \
    ${MEDIA_TOOLS_INSTALL} \
    ${GRAPHICS_LIBS} \
    ${UTILITIES_INSTALL} \
"

inherit extrausers
EXTRA_USERS_PARAMS = " \
    useradd -P omega -G sudo omega; \
"

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
