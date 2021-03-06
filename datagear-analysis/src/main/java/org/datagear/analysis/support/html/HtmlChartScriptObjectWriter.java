/*
 * Copyright (c) 2018 datagear.tech. All Rights Reserved.
 */

/**
 * 
 */
package org.datagear.analysis.support.html;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.datagear.analysis.ChartDataSet;
import org.datagear.analysis.ChartDefinition;
import org.datagear.analysis.DataSet;
import org.datagear.analysis.DataSetException;
import org.datagear.analysis.DataSetResult;
import org.datagear.analysis.support.AbstractDataSet;

/**
 * {@linkplain HtmlChart} JS脚本对象输出流。
 * 
 * @author datagear@163.com
 *
 */
public class HtmlChartScriptObjectWriter extends AbstractHtmlScriptObjectWriter
{
	public HtmlChartScriptObjectWriter()
	{
		super();
	}

	/**
	 * 将{@linkplain HtmlChart}的JS脚本对象写入输出流。
	 * <p>
	 * 格式为：
	 * </p>
	 * <code>
	 * <pre>
	 * var [chart.varName]=
	 * {
	 * 	...,
	 * 	renderContext : [renderContextVarName],
	 * 	plugin : [pluginVarName],
	 * 	...
	 * };
	 * <pre>
	 * </code>
	 * 
	 * @param out
	 * @param chart
	 * @param renderContextVarName
	 * @param pluginVarName
	 * @throws IOException
	 */
	public void write(Writer out, HtmlChart chart, String renderContextVarName, String pluginVarName) throws IOException
	{
		chart = new JsonHtmlChart(chart, renderContextVarName, pluginVarName);

		out.write("var " + chart.getVarName() + "=");
		writeNewLine(out);
		writeJsonObject(out, chart);
		out.write(";");
		writeNewLine(out);
	}

	/**
	 * 支持JSON输出的{@linkplain HtmlChart}。
	 * 
	 * @author datagear@163.com
	 *
	 */
	protected static class JsonHtmlChart extends HtmlChart
	{
		public JsonHtmlChart(HtmlChart htmlChart, String renderContextVarName, String pluginVarName)
		{
			super();
			ChartDefinition.copy(htmlChart, this);
			setChartDataSets(JsonChartDataSet.valuesOf(htmlChart.getChartDataSets()));
			setPlugin(new RefHtmlChartPlugin(pluginVarName));
			setRenderContext(new RefHtmlRenderContext(renderContextVarName));
			setElementId(htmlChart.getElementId());
			setVarName(htmlChart.getVarName());
		}
	}

	protected static class JsonChartDataSet extends ChartDataSet
	{
		public JsonChartDataSet(ChartDataSet chartDataSet)
		{
			super(new JsonDataSet(chartDataSet.getDataSet()));
			setPropertySigns(chartDataSet.getPropertySigns());
		}

		public static JsonChartDataSet[] valuesOf(ChartDataSet[] chartDataSets)
		{
			if (chartDataSets == null)
				return null;

			JsonChartDataSet[] jsonDataSets = new JsonChartDataSet[chartDataSets.length];

			for (int i = 0; i < chartDataSets.length; i++)
				jsonDataSets[i] = new JsonChartDataSet(chartDataSets[i]);

			return jsonDataSets;
		}
	}

	protected static class JsonDataSet extends AbstractDataSet
	{
		public JsonDataSet(DataSet dataSet)
		{
			super(dataSet.getId(), dataSet.getName(), dataSet.getProperties());
			setParams(dataSet.getParams());
			setExports(dataSet.getExports());
		}

		@Override
		public DataSetResult getResult(Map<String, ?> paramValues) throws DataSetException
		{
			return null;
		}
	}
}
