DESCRIPTION = "U-Boot port for friendlyarm"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"


# No patches for other machines yet

COMPATIBLE_MACHINE = "nanopi-neo-air"

DEFAULT_PREFERENCE_nanopi-neo-air="1"

SPL_BINARY="u-boot-sunxi-with-spl.bin"

SRC_URI = " \
        git://github.com/friendlyarm/u-boot.git;protocol=https;branch=sunxi-v2017.x \
	file://0001-Fix-for-eMMC-on-NanoPI-NEO-Air.patch \
        file://boot.cmd \
	"

PE = "1"

SRCREV = "2013d886f15cbe78d3806a0168a9c6e432ddd4cf"
SRCPV = "v2017.x+git${SRCREV}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
  
