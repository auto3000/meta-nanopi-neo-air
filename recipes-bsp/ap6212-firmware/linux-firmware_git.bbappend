FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI_append = "\
    file://LICENSE.broadcom_brcm80211 \
    file://brcmfmac43430-sdio.bin \
    file://brcmfmac43430-sdio.txt \
    file://bcm43438a0.hcd \
    "

do_install_append() {
    cp ${WORKDIR}/brcmfmac43430-sdio.* ${D}/lib/firmware/brcm

    mkdir -p ${D}/etc/firmware/ap6212
    cp ${WORKDIR}/bcm43438a0.hcd ${D}/etc/firmware/ap6212/4343A0.hcd
}
