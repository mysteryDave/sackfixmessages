package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class SpreadOrBenchmarkCurveDataComponent(spreadField:Option[SpreadField]=None,
                                               benchmarkCurveCurrencyField:Option[BenchmarkCurveCurrencyField]=None,
                                               benchmarkCurveNameField:Option[BenchmarkCurveNameField]=None,
                                               benchmarkCurvePointField:Option[BenchmarkCurvePointField]=None,
                                               benchmarkPriceField:Option[BenchmarkPriceField]=None,
                                               benchmarkPriceTypeField:Option[BenchmarkPriceTypeField]=None,
                                               benchmarkSecurityIDField:Option[BenchmarkSecurityIDField]=None,
                                               benchmarkSecurityIDSourceField:Option[BenchmarkSecurityIDSourceField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    spreadField.foreach(fmt(b,_))
    benchmarkCurveCurrencyField.foreach(fmt(b,_))
    benchmarkCurveNameField.foreach(fmt(b,_))
    benchmarkCurvePointField.foreach(fmt(b,_))
    benchmarkPriceField.foreach(fmt(b,_))
    benchmarkPriceTypeField.foreach(fmt(b,_))
    benchmarkSecurityIDField.foreach(fmt(b,_))
    benchmarkSecurityIDSourceField.foreach(fmt(b,_))
    b
  }

}
     
object SpreadOrBenchmarkCurveDataComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    SpreadField.TagId, BenchmarkCurveCurrencyField.TagId, BenchmarkCurveNameField.TagId, BenchmarkCurvePointField.TagId, BenchmarkPriceField.TagId, 
    BenchmarkPriceTypeField.TagId, BenchmarkSecurityIDField.TagId, BenchmarkSecurityIDSourceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SpreadField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SpreadOrBenchmarkCurveDataComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SpreadOrBenchmarkCurveDataComponent(myFields.get(SpreadField.TagId).flatMap(f=>SpreadField.decode(f)),
        myFields.get(BenchmarkCurveCurrencyField.TagId).flatMap(f=>BenchmarkCurveCurrencyField.decode(f)),
        myFields.get(BenchmarkCurveNameField.TagId).flatMap(f=>BenchmarkCurveNameField.decode(f)),
        myFields.get(BenchmarkCurvePointField.TagId).flatMap(f=>BenchmarkCurvePointField.decode(f)),
        myFields.get(BenchmarkPriceField.TagId).flatMap(f=>BenchmarkPriceField.decode(f)),
        myFields.get(BenchmarkPriceTypeField.TagId).flatMap(f=>BenchmarkPriceTypeField.decode(f)),
        myFields.get(BenchmarkSecurityIDField.TagId).flatMap(f=>BenchmarkSecurityIDField.decode(f)),
        myFields.get(BenchmarkSecurityIDSourceField.TagId).flatMap(f=>BenchmarkSecurityIDSourceField.decode(f))))
    } else None
  }

    
}
     