{
  'targets': [
    {
      'target_name': 'node_win32ole',
      "include_dirs": [
        "<!(node -e \"require('nan')\")"
      ],
      'sources': [
        'src/node_win32ole.cc',
        'src/win32ole_gettimeofday.cc',
        'src/force_gc_extension.cc',
        'src/force_gc_internal.cc',
        'src/client.cc',
        'src/v8variant.cc',
        'src/ole32core.cpp'
      ],
      'dependencies': [
      ]
    }
  ]
}
