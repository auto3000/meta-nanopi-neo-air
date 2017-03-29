inherit base
FILESEXTRAPATHS_append := "${THISDIR}/files"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.broadcom_brcm80211;md5=f60c122b4e8350839f9173c8dd7f2ef9"

SRC_URI = "\
    file://LICENSE.broadcom_brcm80211 \
    file://brcmfmac43430-sdio.bin \
    file://brcmfmac43430-sdio.txt \
    file://bcm43438a0.hcd \
    "

FILES_${PN} = "/lib/firmware/brcm"

do_install_append() {
    mkdir -p ${D}/lib/firmware/brcm
    cp ${WORKDIR}/brcmfmac43430-sdio.* ${D}/lib/firmware/brcm
    cp ${WORKDIR}/bcm43438a0.hcd ${D}/lib/firmware/brcm
}
