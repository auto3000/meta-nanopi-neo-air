COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|nanopi-neo|nanopi-neo-air)"

FILESEXTRAPATHS_append := ":${THISDIR}/sunxi-files"

SRCREV_pn-${PN} = "0338e0e1aee965589bd391680a1dcb3c133a0bad"

SRC_URI = "git://github.com/lcrb/h3_lichee.git;branch=master;protocol=git \
    file://0001-gcc-version.patch \
    file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
    file://0002-brom.patch \
    file://0001-fix_cfg80211.patch \
    file://defconfig \
    "
