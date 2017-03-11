SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|nanopi-neo)"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"

LINUX_VERSION ?= "4.10.1"
PV = "4.10.1"

SRC_URI[md5sum] = "ed01fa8c30342def9712769762ca55ea"
SRC_URI[sha256sum] = "6ca06bb5faf5f83600d7388bb623dae41df2a257de85ad5d1792e03302bc3543"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
	file://defconfig \
	file://AP6212.cfg \
	file://0001-add-audio-sunxi-h3.patch \
	file://0002-add-ap6212-h3.patch \
	"
