FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI_append = "\
    file://LICENSE.broadcom_brcm80211 \
    file://brcmfmac43430-sdio.bin \
    file://brcmfmac43430-sdio.txt \
    "

do_install_append() {
    cp ${WORKDIR}/brcmfmac43430-sdio.* ${D}/lib/firmware/brcm
}
