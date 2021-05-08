package com.example.DatabaseService.service;

import com.example.DatabaseService.model.RowMaterial;
import com.example.DatabaseService.repository.RowMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowMaterialService {

    private RowMaterialRepository rowMaterialRepository;

    public RowMaterialService(RowMaterialRepository rowMaterialRepository) {
        this.rowMaterialRepository = rowMaterialRepository;
    }

    public boolean addStock(RowMaterial rowMaterial){
        try{
            List<RowMaterial> rowMaterials = rowMaterialRepository.findBySizeAndGpmAndColorAndWeight(rowMaterial.getSize(), rowMaterial.getGpm(), rowMaterial.getColor().toLowerCase(), rowMaterial.getWeight());

            // check if any matched data is available or not if yes then update that data
            if(rowMaterials.size()>0){
                rowMaterials.get(0).setStock(rowMaterials.get(0).getStock() + rowMaterial.getStock());
                rowMaterialRepository.save(rowMaterials.get(0));
            }else{
                rowMaterial.setColor(rowMaterial.getColor().toLowerCase());
                rowMaterialRepository.save(rowMaterial);
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<RowMaterial> getRowMaterial(Double size, String color){
        try{
            if(color.equals("")){
                return rowMaterialRepository.findBySize(size);
            }else if(size==0.0){
                return rowMaterialRepository.findByColor(color);
            }
            return rowMaterialRepository.findBySizeAndColor(size, color.toLowerCase());
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean updateRowMaterial(Double size, String color,int stock){
        try {
            List<RowMaterial> rowMaterials = getRowMaterial(size, color);
            // checked is there material is available or not
            if(rowMaterials.get(0).getStock()-stock < 0){
                return false;
            }
            rowMaterials.get(0).setStock(rowMaterials.get(0).getStock()-stock);
            rowMaterialRepository.save(rowMaterials.get(0));
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public List<RowMaterial> searchAll(){
        try{
            return rowMaterialRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
