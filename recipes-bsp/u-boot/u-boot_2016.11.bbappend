DESCRIPTION="Upstream's U-boot configured for sunxi devices"
FILESEXTRAPATHS_append := ":${THISDIR}/files"

COMPATIBLE_MACHINE = "nanopi-neo-air"

SRC_URI_append = " \
    file://0001-add-uboot-air.patch \
"
