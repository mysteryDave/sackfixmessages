package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class DerivativeSecurityDefinitionComponent(derivativeInstrumentComponent:Option[DerivativeInstrumentComponent]=None,
                                                 derivativeInstrumentAttributeComponent:Option[DerivativeInstrumentAttributeComponent]=None,
                                                 marketSegmentGrpComponent:Option[MarketSegmentGrpComponent]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    derivativeInstrumentComponent.foreach(fmt(b,_))
    derivativeInstrumentAttributeComponent.foreach(fmt(b,_))
    marketSegmentGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object DerivativeSecurityDefinitionComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DerivativeInstrumentComponent.isMandatoryField(tagId) || DerivativeInstrumentAttributeComponent.isMandatoryField(tagId) || MarketSegmentGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DerivativeInstrumentComponent.isOptionalField(tagId) || DerivativeInstrumentAttributeComponent.isOptionalField(tagId) || MarketSegmentGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DerivativeInstrumentComponent.isFieldOf(tagId) || DerivativeInstrumentAttributeComponent.isFieldOf(tagId) || MarketSegmentGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = DerivativeInstrumentComponent.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DerivativeSecurityDefinitionComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DerivativeSecurityDefinitionComponent(DerivativeInstrumentComponent.decode(flds, startPos),
        DerivativeInstrumentAttributeComponent.decode(flds, startPos),
        MarketSegmentGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     