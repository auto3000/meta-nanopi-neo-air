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
SRCREV = "e4daaacfe78c1279a464a1cdb70c7c74fbca6240"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/igorpecovnik/linux.git;protocol=https;branch=sun8i \
	file://defconfig.cfg \
    file://add-gcc6.patch \
    file://0001-Fix-compilation-problems-with-more-modern-version-of.patch \
    file://0001-Fix-ump-build.patch \
    file://0001-gc2035-camera-improvements.patch \
    file://0001-hid-Add-new-driver-for-non-compliant-Xin-Mo-devices.patch \
    file://0001-UBUNTU-SAUCE-AppArmor-Add-profile-introspection-file.patch \
    file://0001-vfe-sets-valid-input-when-open-device.patch \
    file://0002-UBUNTU-SAUCE-AppArmor-basic-networking-rules.patch \
    file://0003-UBUNTU-SAUCE-apparmor-Add-the-ability-to-mediate-mou.patch \
    file://0006-sunxi-disp2-FBIO_WAITFORVSYNC-as-a-modifier-for-FBIO.patch \
    file://0010-Import-GMAC_PHY_POWER-support-from-the-loboris-sourc.patch \
    file://0011-gpu-drm-Add-Mali-DX910-SW-99002-r2p4-02rel1.patch \
    file://0012-drm-mali-fix-for-3.4.patch \
    file://0013-gpu-drm-mali_drv-fixed-integration-with-3.x-kernels-.patch \
    file://0015-Fix-paths-to-files-in-src-erroneously-searched-for-i.patch \
    file://0016-gcc5-fixes.patch \
    file://0023-WIP-remove-vsync_task-from-sunxi-fb-driver.patch \
    file://0024-pwm-sunxi-support-for-H3-as-appears-in-loboris-initi.patch \
    file://0025-h3-hdmi-table-reformatting-for-readability-from-lobo.patch \
    file://0026-h3-hdmi-additional-mode-800x480p-from-lobodis-initia.patch \
    file://0027-h3-hdmi-HDMI_EDID-from-loboris-initial-source-import.patch \
    file://0028-lower-minimal-dram-clock-to-132-mhz.patch \
    file://02-0003-linux-sunxi-3.4.108-overlayfs.patch \
    file://02-0005-backport-firmware-loader.patch \
    file://02-0007-fbdev-fixes.patch.patch \
    file://02-0008-backport-lirc-sunxi-driver.patch \
    file://02-0009-unify-ethernet-settings.patch \
    file://02-0010-export_read_current_timer.patch \
    file://02-0011-fbtft_for_older.patch \
    file://02-0013-w1_h3.patch \
    file://02-0014-no_dev_console.patch \
    file://02-0015-openelec-audio-and-video-fixes.patch \
    file://02-rtl2832.patch \
    file://add-mali-r3p0-fixed.patch \
    file://bash_to_afterinstall.patch \
    file://cedar-remove-insecure-code.patch \
    file://cpufreq-add-more-frequencies.patch \
    file://disp2-fb-force-soft-cursor.patch \
    file://enable_g_ether.patch \
    file://fix-kswapd.patch \
    file://friendlyarm_audio_able_to_handle_situation_without_audio_pa_ctrl_.patch \
    file://friendlyarm_crypto_add_CMAC_support_to_CryptoAPI.patch \
    file://friendlyarm_fix_nanopi-air_sdcard_detect_mode.patch \
    file://friendlyarm_m1_gigabit.patch \
    file://friendlyarm_not_print_debug_info_when_camera_is_detached.patch \
    file://friendlyarm_watchdog_not_print_err_info_when_timeout_is_invalid.patch \
    file://linux-202-bcmdhd-add-wow-selection.patch \
    file://linux-203-rf_pm-auto-power-on.patch \
    file://linux-509-support-for-dvbsky-usb-receiver.patch \
    file://linux-82-fix-build-on-non-amd64-hosts.patch \
    file://linux-88-enable-tv.patch \
    file://m2-plus-ap6212-wireless.patch \
    file://m2-update-bcmdhd-driver.patch \
    file://make-irq-set-affinity-hint-work-properly.patch \
    file://matrix-support-Matrix-starter-kit.patch \
    file://ov5640-enhanced-driver-with-vfe-drc-table-fix.patch \
    file://packaging-3.4.x-DEFAULT-with-postinstall-scripts.patch \
    file://packaging-text-fix.patch \
    file://remove-sunxi-debug.patch \
    file://sun8i-add-scaling_available_freqs-sysfs-node.patch \
    file://sun8i-led-behaviour-through-fex.patch \
    file://sun8i-simple-cpu-corekeeper.patch \
    file://tbs5520.patch \
    file://wdt_reduce_logging.patch \
    file://wireless-opi-zero.patch \
    file://z-0003-add-additional-video-modes.patch \
        "
