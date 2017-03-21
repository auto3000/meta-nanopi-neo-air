inherit base
FILESEXTRAPATHS_append := "${THISDIR}/files:"
INSANE_SKIP_${PN} = "already-stripped"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.broadcom;md5=18b6b752a010900b9c111f528f8c8ffd"

DEPENDS = "bluez5"
SRC_URI = "file://brcm_patchram_plus"

FILES_${PN} = "/usr/bin/*"

do_install_append() {
    install -d ${D}/usr/bin
    install -m 755 ${WORKDIR}/brcm_patchram_plus ${D}/usr/bin 
}
