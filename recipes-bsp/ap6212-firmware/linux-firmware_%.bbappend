FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://LICENSE.broadcom_brcm80211 \
    file://brcmfmac43430-sdio.bin \
    file://brcmfmac43430-sdio.txt \
    file://bcm43438a0.hcd \
    "
do_install_append() {
    mkdir -p  ${D}/${nonarch_base_libdir}/firmware/brcm
    cp ${WORKDIR}/brcmfmac43430-sdio.* ${D}/${nonarch_base_libdir}/firmware/brcm

    mkdir -p ${D}/${sysconfdir}/firmware/ap6212
    cp ${WORKDIR}/bcm43438a0.hcd ${D}/${sysconfdir}/firmware/ap6212/4343A0.hcd
}

FILES_${PN}-bcm43430 += " \
  ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.bin \
  ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.txt \
  ${sysconfdir}/firmware/ap6212/bcm43438a0.hcd \
  "

