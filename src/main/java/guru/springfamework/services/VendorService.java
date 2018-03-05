package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO getVendorByName(String name);

    public VendorDTO createNewVendor(VendorDTO vendorDTO);

    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    public void deleteVendorById(Long id);
}
