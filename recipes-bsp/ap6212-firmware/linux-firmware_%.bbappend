FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://LICENSE.broadcom_brcm80211 \
    file://brcmfmac43430a1-sdio.txt \
    file://brcmfmac43430a0-sdio.bin \
    file://brcmfmac43430a0-sdio.txt \
    file://bcm43438a0.hcd \
    file://bcm43438a1.hcd \
    "
do_install_append() {
    install -D -m 0644 ${WORKDIR}/brcmfmac43430a0-sdio.* ${D}/${nonarch_base_libdir}/firmware/brcm
    install -D -m 0644 ${WORKDIR}/brcmfmac43430a1-sdio.txt ${D}/${nonarch_base_libdir}/firmware/brcm
    ln -sf brcmfmac43430-sdio.bin ${D}/${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a1-sdio.bin

    install -D -m 0644 ${WORKDIR}/bcm43438a0.hcd ${D}/${sysconfdir}/firmware/ap6212/4343A0.hcd
    install -D -m 0644 ${WORKDIR}/bcm43438a1.hcd ${D}/${sysconfdir}/firmware/ap6212/4343A1.hcd
}

FILES_${PN}-bcm43430 += " \
  ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a1-sdio.bin \
  ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a1-sdio.txt \
  ${sysconfdir}/firmware/ap6212/bcm43438a1.hcd \
  ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a0-sdio.bin \
  ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a0-sdio.txt \
  ${sysconfdir}/firmware/ap6212/bcm43438a0.hcd \
  "

