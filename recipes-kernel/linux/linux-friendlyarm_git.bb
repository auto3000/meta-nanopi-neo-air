SECTION = "kernel"
DESCRIPTION = "Friendlyarm Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|nanopi-neo|nanopi-neo-air)"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

# Default is to use stable kernel version
# If you want to use latest git version set to "1"
DEFAULT_PREFERENCE = "-1"

PV="4.11"
SRCREV = "5fd7aa916e6c93df69f184b03e37cca0284f9550"

SRC_URI = "git://github.com/friendlyarm/linux.git;protocol=https;branch=sunxi-4.11.y \
        file://defconfig \
        "
S = "${WORKDIR}/git"

