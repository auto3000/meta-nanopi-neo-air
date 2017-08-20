SECTION = "kernel"
DESCRIPTION = "Armbian Linux kernel"
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

PV="3.4"
SRCREV = "e2f9fc4795ca9bf740822cad9e0e54ea33a060fb"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/megous/linux.git;protocol=https;branch=orange-pi-4.11 \
        file://defconfig \
    file://spidev-remove-warnings.patch \
    file://add-uart-rts-cts-pins.patch \
    file://scripts-dtc-import-updates.patch \
    file://fix-broken-usb0-drv.patch \
    file://fix-i2c2-reg-property.patch \
    file://add-BergMicro-SPI-flashes.patch \
    file://add-realtek-8189fs-driver.patch \
    file://add-fix-dts-for-opi-zero-emac.patch \
    file://spi-sun6i-allow-large-transfers.patch \
    file://add-nanopi-neoair.patch \
    file://packaging-4.x-DEV-with-postinstall-scripts.patch \
    file://add-spi-aliases.patch \
    file://add-h3-overlays.patch \
    file://enable-codec-opi-2.patch \
    file://add-spi-flash-opi-zero.patch \
    file://add-wifi-pwrseq-opi-pc-plus.patch \
    file://add-configfs-overlay-for-v4.11.x.patch \
    file://add-orangepi-zeroplus.patch \
    file://add-emac-pwr-en-orangepi-plus2e.patch \
    file://add-dvfs-emac-nanopi.patch \
    file://add-h3-simplefb.patch \
    file://resolve-crypto-deps.patch \
    file://add-overlay-compilation-support.patch \
    file://add-ad9834-dt-bindings.patch \
    file://add-thermal-otg-wireless-opi-lite.patch \
        "

