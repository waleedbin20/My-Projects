# 
# Synthesis run script generated by Vivado
# 

set_msg_config -id {HDL 9-1061} -limit 100000
set_msg_config -id {HDL 9-1654} -limit 100000
create_project -in_memory -part xc7a35tcpg236-1

set_param project.singleFileAddWarning.threshold 0
set_param project.compositeFile.enableAutoGeneration 0
set_param synth.vivado.isSynthRun true
set_property webtalk.parent_dir {M:/CE 264/stage2/hsyctest/project_1/project_1.cache/wt} [current_project]
set_property parent.project_path {M:/CE 264/stage2/hsyctest/project_1/project_1.xpr} [current_project]
set_property default_lib xil_defaultlib [current_project]
set_property target_language Verilog [current_project]
read_vhdl -library xil_defaultlib {
  {M:/CE 264/stage2/hsyctest/hsynch_vsynch_pkg.vhd}
  {M:/CE 264/stage2/hsyctest/hsynch_vsynch.vhd}
}
foreach dcp [get_files -quiet -all *.dcp] {
  set_property used_in_implementation false $dcp
}
read_xdc {{M:/CE 264/stage1/7segment/basys3_master/Basys3_Master.xdc}}
set_property used_in_implementation false [get_files {{M:/CE 264/stage1/7segment/basys3_master/Basys3_Master.xdc}}]


synth_design -top hsynch_vsynch -part xc7a35tcpg236-1


write_checkpoint -force -noxdef hsynch_vsynch.dcp

catch { report_utilization -file hsynch_vsynch_utilization_synth.rpt -pb hsynch_vsynch_utilization_synth.pb }
